package PhotoEditor;

public class PhotoEffect {
	
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image.
	 */
	public static Photo resize(Photo image, int newWidth, int newHeight) {
		Photo newImage = new Photo(newWidth, newHeight);
		
		for (int x = 0 ; x < newWidth ; x++) {
			for (int y = 0 ; y < newHeight ; y++) {
				int newPixel = image.getPixel(x * image.getWidth() / newWidth, y * image.getHeight() / newHeight);
				newImage.setPixel(x, y, newPixel);
			}
		}
		return newImage;
	}
	
	/**
	 * Halfs the width and height of the input image.
	 */
	public static Photo half(Photo image) {
		return resize(image, image.getWidth() / 2, image.getHeight() / 2);
	}

	/**
	 * Resizes the input image to the same size as the reference image.
	 */
	public static Photo resize(Photo image, Photo reference) {
		return resize(image, reference.getWidth(), reference.getHeight());
	}

	/**
	 * Make a copy of the input image.
	 */
	public static Photo copy(Photo image) {
		return resize(image, image.getWidth(), image.getHeight());
	}
	
	/**
	 * An example filter. Modify the code in the specified area to change how it works. 
	 * @param image
	 * @return
	 */
	public static Photo exampleFilter(Photo image) {
		for (int x = 0 ; x < image.getWidth() ; x = x + 1) {
			for (int y = 0 ; y < image.getHeight() ; y = y + 1) {
				// Modify code here
				// ----------------
				int red = image.getRed(x, y);
				int green = image.getGreen(x, y);
				int blue = image.getBlue(x, y);
				
				// The createPixel method takes in red, green, and blue as an input, and returns a
				// corresponding pixel.
				int pixel = createPixel(red, green, blue);
				
				image.setPixel(x, y, pixel);
				// ----------------
			}
		}
		return image;
	}
	
	/**
	 *	Add some funk to the image.
	 */
	public static Photo funky(Photo image, Photo background) {
		return image;
	}
	
    /**
     * Convert the image to grayscale. This is done by going to every pixel and taking the
     * average of R, G, and B, and setting each of R, G, and B to the average.
     */
	public static Photo grayscale(Photo image) {
		return image;
	}
	
	/**
	 * To brighten, add to the R, G, and B values for each pixel.
	 */
	public static Photo brighten(Photo image) {
		return image;
	}
	
	/**
	 * To darken, subtract from the R, G, and B values for each pixel.
	 */
	public static Photo darken(Photo image) {
		return image;
	}
	
	/**
	 *	Flips the image over the x-axis.
	 */
	public static Photo flip(Photo image) {
		return image;
	}

	/**
	 *	Mirrors the image over the y-axis.
	 */
	public static Photo mirror(Photo image) {
		return image;
	}

	/**
	 *	Rotates the image left.
	 */
	public static Photo rotateLeft(Photo image) {
		return image;
	}

	/**
	 *	Rotates the image right.
	 */
	public static Photo rotate(Photo image) {
		// Let me save you some time.
		return rotateLeft(rotateLeft(rotateLeft(image)));
	}

	/** 
	 * Merge the red,blue,green components from two images.
	 */
	public static Photo merge(Photo front, Photo back) {
		return front;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image.
	 */
	public static Photo chromaKey(Photo front, Photo back) {
		return front;
	}
	
	public static Photo process(String cmd, Photo source, Photo background) {
		try {
			if (cmd.equals("Half")) {			return PhotoEffect.half(source); 				}
			if (cmd.equals("Rotate")) {			return PhotoEffect.rotateLeft(source);			}
			if (cmd.equals("Flip")) {			return PhotoEffect.flip(source);				}
			if (cmd.equals("Mirror")) {			return PhotoEffect.mirror(source);				}
			if (cmd.equals("Example")) {		return PhotoEffect.exampleFilter(source);		}
			if (cmd.equals("Funky")) {			return PhotoEffect.funky(source,background);	}
			if (cmd.equals("Grayscale")) {		return PhotoEffect.grayscale(source);			}
			if (cmd.equals("Brighten")) {		return PhotoEffect.brighten(source);			}
			if (cmd.equals("Darken")) {			return PhotoEffect.darken(source);				}
			if (cmd.equals("Size To")) {		return PhotoEffect.resize(source, background);  }
			if (cmd.equals("Merge")) {			return PhotoEffect.merge(source, background);	 }
			if (cmd.equals("Chromakey")) {		return PhotoEffect.chromaKey(source, background);}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			PhotoEditor.failure("Array index went out of bounds.");
			PhotoEditor.failure(e.getMessage());
			return null;
		}
		return source;
	}
	
	public static String[][] getMenu() {
		return new String[][] {
			{ "Size", 		/* Contents */ "Half", "Rotate", "Flip", "Mirror" },
			{ "Color", 		/* Contents */ "Example", "Funky", "Grayscale", "Brighten", "Darken" },
			{ "Combine", 	/* Contents */ "Size To", "Merge", "Chromakey" }
		};
	}
	
	/**
	 * Utility method for combining RGB values.
	 */
	public static int createPixel(int red, int green, int blue) {
		return (red << 16 | green << 8 | blue);
	}
}
