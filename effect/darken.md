```java


	/**
	 * To darken, subtract from the R, G, and B values for each pixel.
	 */
	public static Photo darken(Photo image) {
		for (int x = 0 ; x < image.getWidth() ; x = x + 1) {
			for (int y = 0 ; y < image.getHeight() ; y = y + 1) {
				// Modify code here
				// ----------------
				int red = image.getRed(x, y) - 20;
				int green = image.getGreen(x, y) - 20;
				int blue = image.getBlue(x, y) - 20;
				
				if (red < 0) {
					red = 0;
				}
				if (green < 0) {
					green = 0;
				}
				if (blue < 0) {
					blue = 0;
				}
				
				// The createPixel method takes in red, green, and blue as an input, and returns a
				// corresponding pixel.
				int pixel = createPixel(red, green, blue);
				
				image.setPixel(x, y, pixel);
				// ----------------
			}
		}
		return image;
	}
	
	```
