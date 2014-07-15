```java
  public static Photo grayscale(Photo image) {
		for (int x = 0 ; x < image.getWidth() ; x = x + 1) {
			for (int y = 0 ; y < image.getHeight() ; y = y + 1) {
				int red = image.getRed(x, y);
				int green = image.getGreen(x, y);
				int blue = image.getBlue(x, y);
				
				int average = (red + green + blue) / 3;
				
				int pixel = createPixel(average, average, average);
				
				image.setPixel(x, y, pixel);
				// ----------------
			}
		}
		return image;
	}
```
