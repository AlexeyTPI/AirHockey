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
import java.util.Map;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "shapes" example.
 */

public class Polygon {

    private static Polygon polygonSingleton;
    public static int widthPolygon = 300;
    public static int heightPolygon = 400;
    private static CustomRectangle background;
    private final JFrame frame;
    private final CanvasPane canvas;
    private Graphics2D graphic;
    private final Color backgroundColor;
    private Image canvasImage;
    private final Timer timer;
    private final List<Object> objects;
    private final Map<Object, VisualDescription> visual;

    /**
     * Factory method to get the canvas singleton object.
     * @return object of type Polygon.
     */
    public static Polygon getPolygon() {
        if (Polygon.polygonSingleton == null) {
            Polygon.polygonSingleton = new Polygon("BlueJ Shapes Demo", widthPolygon, heightPolygon,
                    Color.white);
            background = new CustomRectangle();
            background.changeColor("blue");
            background.changeSide(widthPolygon, heightPolygon - 100);
            background.moveHorizontal(-60);
            background.moveVertical(-50);
            background.show();
        }
        Polygon.polygonSingleton.setVisible(true);
        return Polygon.polygonSingleton;
    }

    /**
     * Create a Canvas.
     *
     * @param title           title to appear in Canvas Frame
     * @param width           the desired width for the canvas
     * @param height          the desired height for the canvas
     * @param backgroundColor the desired background colour of the canvas
     */
    private Polygon(String title, int width, int height, Color backgroundColor) {
        this.frame = new JFrame();
        this.canvas = new CanvasPane();
        this.frame.setContentPane(this.canvas);
        this.frame.setTitle(title);
        this.canvas.setPreferredSize(new Dimension(width, height));
        this.timer = new javax.swing.Timer(5, null);
        this.timer.start();
        this.backgroundColor = backgroundColor;
        this.frame.pack();
        this.objects = new ArrayList<>();
        this.visual = new HashMap<>();
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     *
     * @param visible boolean value representing the desired visibility of
     *                the canvas (true or false)
     */
    public void setVisible(boolean visible) {
        if (this.graphic == null) {
            Dimension size = this.canvas.getSize();
            this.canvasImage = this.canvas.createImage(size.width, size.height);
            this.graphic = (Graphics2D) this.canvasImage.getGraphics();
            this.graphic.setColor(this.backgroundColor);
            this.graphic.fillRect(0, 0, size.width, size.height);
            this.graphic.setColor(Color.black);
        }
        this.frame.setVisible(visible);
    }

    /**
     * Draw a given shape onto the canvas.
     *
     * @param objects an object to define identity for this shape
     * @param color   the color of the shape
     * @param shape   the shape object to be drawn on the canvas
     */
    public void draw(Object objects, String color, Shape shape) {
        this.objects.remove(objects);
        this.objects.add(objects);
        this.visual.put(objects, new VisualDescription(shape, color));
        this.redraw();
    }

    /**
     * Erase a given shape's from the screen.
     *
     * @param object the shape object to be erased
     */
    public void erase(Object object) {
        this.objects.remove(object);
        this.visual.remove(object);
        this.redraw();
    }

    /**
     * Set the foreground colour of the Canvas.
     *
     * @param newColor the new colour for the foreground of the Canvas
     */
    public void setForegroundColor(String newColor) {
        switch (newColor) {
            case "red" -> this.graphic.setColor(Color.red);
            case "blue" -> this.graphic.setColor(Color.blue);
            case "yellow" -> this.graphic.setColor(Color.yellow);
            case "green" -> this.graphic.setColor(Color.green);
            case "magenta" -> this.graphic.setColor(Color.magenta);
            case "white" -> this.graphic.setColor(Color.white);
            default -> this.graphic.setColor(Color.black);
        }
    }

    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     *
     * @param milliseconds the number
     */
    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println("Waiting was not completed yet");
        }
    }

    /**
     * * Redraw all shapes currently on the Canvas.
     */
    private void redraw() {
        this.erase();
        for (Object shape : this.objects) {
            this.visual.get(shape).draw(this.graphic);
        }
        this.canvas.repaint();
    }

    /**
     * Erase the whole canvas. (Does not repaint.)
     */
    private void erase() {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColor);
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
            graphic.drawImage(Polygon.this.canvasImage, 0, 0, null);
        }
    }

    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class VisualDescription {
        private final Shape visual;
        private final String color;

        public VisualDescription(Shape visual, String color) {
            this.visual = visual;
            this.color = color;
        }

        public void draw(Graphics2D graphic) {
            Polygon.this.setForegroundColor(this.color);
            graphic.fill(this.visual);
        }
    }
}
