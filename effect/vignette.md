```java
  public static Photo vignette(Photo image) {
		int centerx = image.getWidth() / 2;
		int centery = image.getHeight() / 2;
		
		for (int x = 0 ; x < image.getWidth() ; x++) {
			for (int y = 0 ; y < image.getHeight() ; y++) {
				// casting
				int distance = (int) Math.sqrt(Math.pow(x - centerx, 2) + Math.pow(y - centery, 2));
				distance = distance / 10;
				
				int red = image.getRed(x, y) - distance;
				if (red < 0) {
					red = 0;
				}
				int green = image.getGreen(x, y) - distance;
				if (green < 0) {
					green = 0;
				}
				int blue = image.getBlue(x, y) - distance;
				if (blue < 0) {
					blue = 0;
				}
				
				// The createPixel method takes in red, green, and blue as an input, and returns a
				// corresponding pixel.
				int pixel = createPixel(red, green, blue);
				
				image.setPixel(x, y, pixel);
			}
		}
		
		return image;
	}
```
