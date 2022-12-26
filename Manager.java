import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

/**
 * Automaticaly sends commands to the objects:<br />
 * moveDown() - when button DOWN is pressed<br />
 * moveUp() - when button UP is pressed<br />
 * moveLeft() - when button LEFT is presed<br />
 * moveRight() - when button RIGHT is pressed<br />
 * activate() - when button SPACE or ENTER is pressed<br />
 * cancel() - when button ESC is pressed<br />
 * tik() - every 0,25 seconds<br />
 * chooseDiraction(x, y) - when the mouse button was pressed
 */
public class Manager {
    private ArrayList<Object> managedObjects;
    private ArrayList<Integer> deletedObjects;
    private long oldTick;
    private static final long TICK_LENGTH = 250000000;
    
    private class ManagerButton extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                Manager.this.sendCommand("moveDown");
            } else if (event.getKeyCode() == KeyEvent.VK_UP) {
                Manager.this.sendCommand("moveUp");
            } else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
                Manager.this.sendCommand("moveLeft");
            } else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
                Manager.this.sendCommand("moveRight");
            } else if (event.getKeyCode() == KeyEvent.VK_SPACE || event.getKeyCode() == KeyEvent.VK_ENTER) {
                Manager.this.sendCommand("activate(");
            } else if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Manager.this.sendCommand("cancel");
            }
        }
    }
    
    private class Manager implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            long newTick = System.nanoTime();
            if (newTick - Manager.this.oldTick >= Manager.TICK_LENGTH || newTick < Manager.TICK_LENGTH) {
                Manager.this.oldTick = (newTick / Manager.TICK_LENGTH) * Manager.TICK_LENGTH;
                Manager.this.sendCommand("tik");
            }
        }
    }
    
    private class ManagerHasTo extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            if (event.getButton() == MouseEvent.BUTTON1) {
                Manager.this.sendCommand("chooseCoordinate", event.getX(), event.getY());
            }
        }
    }
    
    private void sendCommand(String selector) {
        for (Object adresat : this.managedObjects) {
            try {
                    if (adresat != null) {                    
                    Method command = adresat.getClass().getMethod(selector); //знаходжу метод у класі
                    command.invoke(adresat); //викликаю метод
                }
            } catch (SecurityException | NoSuchMethodException |
                IllegalArgumentException| IllegalAccessException | InvocationTargetException e) { //перевірка та обробка виключень
                this.doNothing();
            } 
        }
        this.removeDeletedObjects();
    }
    
    private void posliSpravu(String selektor, int prvyParameter, int druhyParameter) {
        for (Object adresat : this.managedObjects) {
            try {
                if (adresat != null) {
                    Method command = adresat.getClass().getMethod(selektor, Integer.TYPE, Integer.TYPE);
                    command.invoke(adresat, prvyParameter, druhyParameter);
                }
            } catch (SecurityException e) {
                this.doNothing();
            } catch (NoSuchMethodException e) {
                this.doNothing();
            } catch (IllegalArgumentException e) {
                this.doNothing();
            } catch (IllegalAccessException e) {
                this.doNothing();
            } catch (InvocationTargetException e) {
                this.doNothing();
            }
        }
        this.removeDeletedObjects();
    }
    
    private void doNothing() {
        
    }
    
    private void removeDeletedObjects() {
        if (this.deletedObjects.size() > 0) {
            Collections.sort(this.deletedObjects, Collections.reverseOrder());
            for (int i = this.deletedObjects.size() - 1; i >= 0; i--) {
                this.managedObjects.remove(this.deletedObjects.get(i));
            }
            this.deletedObjects.clear();
        }        
    }
    
    /**
     * Vytvori novy manazer, doen't exist.
     */
    public Manager() {
        this.managedObjects= new ArrayList<Object>();
        this.deletedObjects = new ArrayList<Integer>();
        Poligon.getPoligon().addKeyListener(new ManagerKey());
        Poligon.getPoligon().addTimerListener(new ManagerCasovaca());
        Poligon.getPoligon().addMouseListener(new ManagerHasTo());
    }
    
    /**
     * Manager sends commands to the sertain object.
     */
    public void manageObjects(Object objects) {
        this.managedObjects.add(objects);
    }
    
    /**
     * Manager sends commands to the sertain object.
     */
    public void stopManagingObject(Object object) {
        int index = this.managedObjects.indexOf(objekt);
        if (index >= 0) {
            this.managedObjects.set(index, null);
            this.deletedObjects.add(index);
        }
    }
}
