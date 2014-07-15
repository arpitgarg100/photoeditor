```java
  public static Photo taylorSwift(Photo image) {
		// For every x and y coordinate on the image
		for (int x = 0 ; x < image.getWidth() ; x = x + 1) {
			for (int y = 0 ; y < image.getHeight() ; y = y + 1) {
				// Get the R, G, and B values
				int red = image.getRed(x, y);
				int green = image.getGreen(x, y);
				int blue = image.getBlue(x, y);
				
				// Check for a characteristic of the R, G, B values
				if ( red > green * 12 / 5 && red > blue * 12 / 5 ) {
					// Put the pixel back into the image untouched
					int pixel = createPixel(red, green, blue);
					image.setPixel(x, y, pixel);
				}
				// Otherwise, gray scale the pixel and set the pixel in the
				// image to the gray scaled version
				else {
					int average = (red + green + blue) / 3;
					int pixel = createPixel(average, average, average);
					image.setPixel(x, y, pixel);
				}
			}
		}
		return image;
	}
```
