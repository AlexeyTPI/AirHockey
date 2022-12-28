import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "shapes" example.
 *
 *
 */


public class Poligon {
    // Note: The implementation of this class (specifically the handling of
    // shape identity and colors) is slightly more complex than necessary. This
    // is done on purpose to keep the interface and instance fields of the
    // shape objects in this project clean and simple for educational purposes.

    private static Poligon poligonSingleton;
    public static int widthPoligon = 300;
    public static int heightPoligon = 400;
    private static Rectangle background;











    /**
     * Factory method to get the canvas singleton object.
     */
    public static Poligon getPoligon() {

        if (Poligon.poligonSingleton == null) {
            Poligon.poligonSingleton = new Poligon("BlueJ Shapes Demo", widthPoligon, heightPoligon,
                    Color.white);
            background = new Rectangle();
            background.
            background.changeColor("blue");
            background.changeSides(widthPoligon, heightPoligon - 100);
            background.moveHorizontal(-60);
            background.moveVertical(-50);
            background.display();






        }
        Poligon.poligonSingleton.setVisible(true);
        return Poligon.poligonSingleton;
    }

    //  ----- instance part -----

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color background;
    private Image canvasImage;
    private Timer timer;
    private List<Object> objects;
    private HashMap<Object, Visualdescription> visual;

    /**
     * Create a Canvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgColor  the desired background colour of the canvas
     */
    private Poligon(String Ntitle, int width, int height, Color background) {
        this.frame = new JFrame();
        this.canvas = new CanvasPane();
        this.frame.setContentPane(this.canvas);
        this.frame.setTitle(Ntitle);
        this.canvas.setPreferredSize(new Dimension(width, height));
        this.timer = new javax.swing.Timer(25, null);
        this.timer.start();
        this.background = background;
        this.frame.pack();
        this.objects = new ArrayList<Object>();
        this.visual = new HashMap<Object, VisualDescription>();
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false)
     */
    public void setVisible(boolean visible) {
        if (this.graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background colour
            Dimension size = this.canvas.getSize();
            this.canvasImage = this.canvas.createImage(size.width, size.height);
            this.graphic = (Graphics2D)this.canvasImage.getGraphics();
            this.graphic.setColor(this.background);
            this.graphic.fillRect(0, 0, size.width, size.height);
            this.graphic.setColor(Color.black);
        }
        this.frame.setVisible(visible);
    }

    /**
     * Draw a given shape onto the canvas.
     * @param  referenceObject  an object to define identity for this shape
     * @param  color            the color of the shape
     * @param  shape            the shape object to be drawn on the canvas
     */
    // Note: this is a slightly backwards way of maintaining the shape
    // objects. It is carefully designed to keep the visible shape interfaces
    // in this project clean and simple for educational purposes.
    public void draw(Object objects, String color, Shape visual) {
        this.objects.remove(objects);   // just in case it was already there
        this.objects.add(objects);      // add at the end
        this.visual.put(objects, new VisualDescription (tvar, color));
        this.redraw();
    }

    /**
     * Erase a given shape's from the screen.
     * @param  referenceObject the shape object to be erased
     */
    public void erase(Object object) {
        this.objects.remove(object);   // just in case it was already there
        this.visual.remove(object);
        this.redraw();
    }

    /**
     * Set the foreground colour of the Canvas.
     * @param  newColor   the new colour for the foreground of the Canvas
     */
    public void setForegroundColor(String farba) {
        if (farba.equals("red")) {
            this.graphic.setColor(Color.red);
        } else if (farba.equals("black")) {
            this.graphic.setColor(Color.black);
        } else if (farba.equals("blue")) {
            this.graphic.setColor(Color.blue);
        } else if (farba.equals("yellow")) {
            this.graphic.setColor(Color.yellow);
        } else if (farba.equals("green")) {
            this.graphic.setColor(Color.green);
        } else if (farba.equals("magenta")) {
            this.graphic.setColor(Color.magenta);
        } else if (farba.equals("white")) {
            this.graphic.setColor(Color.white);
        } else {
            this.graphic.setColor(Color.black);
        }
    }

    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number
     */
    public void wait(int milisekundy) {
        try {
            Thread.sleep(milisekundy);
        } catch (Exception e) {
            System.out.println("Waiting was not completed yet");
        }
    }

    /**
     * * Redraw all shapes currently on the Canvas.
     */
    private void redraw() {
        this.erase();
        for (Object tvar : this.objects ) {
            this.visual.get(tvar).draw(this.graphic);
        }
        this.canvas.repaint();
    }

    /**
     * Erase the whole canvas. (Does not repaint.)
     */
    private void erase() {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.rectangle);
        Dimension size = this.canvas.getSize();
        this.graphic.fill(new Rectangle(0, 0, size.width, size.height));
        this.graphic.setColor(original);
    }

    public void addKeyListener(KeyListener listener) {
        this.frame.addKeyListener(listener);
    }

    public void addMouseListener(MouseListener listener) {
        this.canvas.addMouseListener(listener);
    }

    public void addTimerListener(ActionListener listener) {
        this.timer.addActionListener(listener);
    }


    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel {
        public void paint(Graphics graphic) {
            graphic.drawImage(Poligon.this.canvasImage, 0, 0, null);
        }
    }

    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class VisualDescription {
        private Shape visual;
        private String color;

        public VisualDescription(Shape visual, String color) {
            this.visual = this.visual;
            this.color = color;
        }

        public void draw(Graphics2D graphic) {
            Poligon.this.setForegroundColor(this.color);
            graphic.fill(this.visual);
        }
    }
}
