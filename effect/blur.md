```java
  public static Photo blur(Photo image) {
		// For every x and y coordinate on the image
		for (int x = 0 ; x < image.getWidth() ; x = x + 1) {
			for (int y = 0 ; y < image.getHeight() ; y = y + 1) {
				int redAverage = 0;
				int blueAverage = 0;
				int greenAverage = 0;
				int count = 0;
				
				int distance = 5;
				for (int dx = x - distance ; dx <= x + distance ; dx = dx + 1) {
					for (int dy = y - distance ; dy <= y + distance ; dy = dy + 1) {
						if (dx >= 0 && dx < image.getWidth() &&
							dy >= 0 && dy < image.getHeight()) {
							redAverage = redAverage + image.getRed(dx, dy);
							greenAverage = greenAverage + image.getGreen(dx, dy);
							blueAverage = blueAverage + image.getBlue(dx, dy);
							count = count + 1;
						}
					}
				}
				
				redAverage = redAverage / count;
				greenAverage = greenAverage / count;
				blueAverage = blueAverage / count;
				
				int pixel = createPixel(redAverage, greenAverage, blueAverage);
				image.setPixel(x, y, pixel);
				
			}
		}
		return image;
	}
```
