package engine;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;


public class Painting {
	
	public static Image floodFillImage(Image image,int x, int y, Color color) 
	{
		BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
		
		int srcColor = bImage.getRGB(x, y);
		
	    boolean[][] hits = new boolean[bImage.getHeight()][bImage.getWidth()];

	    Queue<Point> queue = new LinkedList<Point>();
	    queue.add(new Point(x, y));

	    while (!queue.isEmpty()) 
	    {
	        Point p = queue.remove();

	        if(floodFillImageDo(bImage,hits,p.x,p.y, srcColor, color.getRGB()))
	        { 
	            queue.add(new Point(p.x,p.y - 1)); 
	            queue.add(new Point(p.x,p.y + 1)); 
	            queue.add(new Point(p.x - 1,p.y)); 
	            queue.add(new Point(p.x + 1,p.y)); 
	        }
	    }
	    image = SwingFXUtils.toFXImage(bImage, null);
	    return image;
	}

	private static boolean floodFillImageDo(BufferedImage image, boolean[][] hits,int x, int y, int srcColor, int tgtColor) 
	{
	    if (y < 0) return false;
	    if (x < 0) return false;
	    if (y > image.getHeight()-1) return false;
	    if (x > image.getWidth()-1) return false;

	    if (hits[y][x]) return false;

	    if (image.getRGB(x, y)!=srcColor)
	        return false;

	    // valid, paint it

	    image.setRGB(x, y, tgtColor);
	    hits[y][x] = true;
	    return true;
	}
	
	
	
	/*
	// https://stackoverflow.com/a/40421933
		private void floodFill(double x, double y) {
			Object canvasPane;
			WritableImage i = canvasPane.snapshot(new SnapshotParameters(), null);
	    	PixelReader reader = i.getPixelReader();
	    	int targetColor = reader.getColor((int) x, (int) y).hashCode();
	    	
	    	Object selectedColor;
			if(targetColor == selectedColor.hashCode()) return;
	    	if(targetColor != reader.getColor((int) x, (int) y).hashCode()) return;
	    	gc.setLineWidth(1);
	    	
	    	boolean[][] hits = new boolean[(int) canvasPane.getWidth()][(int) canvasPane.getHeight()];
	    	Queue<PixelCoord> coords = new LinkedList<PixelCoord>();
	    	coords.add(new PixelCoord((int) x, (int) y));
	    	
	    	while(!coords.isEmpty()) {
	    		PixelCoord n = coords.remove();
	    		
	    		if(paintable(reader, n.x, n.y, targetColor, hits)) {
	    			coords.add(new PixelCoord(n.x, n.y-1));
	    			coords.add(new PixelCoord(n.x, n.y+1));
	    			coords.add(new PixelCoord(n.x-1, n.y));
	    			coords.add(new PixelCoord(n.x+1, n.y));
	    		}
	    	}
		}
		*/

}
