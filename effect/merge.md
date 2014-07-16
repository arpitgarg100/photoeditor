```java
  /** 
	 * Merge the red,blue,green components from two images.
	 */
	public static Photo merge(Photo front, Photo back) {
		// Resize the back image to the same size as the front
		back = resize(back, front.getWidth(), front.getHeight());
		// Go to every x, y coordinate
		for (int x = 0 ; x < front.getWidth() ; x = x + 1) {
			for (int y = 0 ; y < front.getHeight() ; y = y + 1) {
				// put front/back pixel into variable
				int averageRed = (front.getRed(x, y) + back.getRed(x, y)) / 2;
				int averageGreen = (front.getGreen(x, y) + back.getGreen(x, y)) / 2;
				int averageBlue = (front.getBlue(x, y) + back.getBlue(x, y)) / 2;
				
				int pixel = createPixel(averageRed, averageGreen, averageBlue);
				front.setPixel(x, y, pixel);
			}
		}
		return front;
	}
```
