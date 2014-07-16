```java
public static Photo mirror(Photo image) {
		for (int x = 0 ; x < image.getWidth() / 2 ; x++) {
			for (int y = 0 ; y < image.getHeight() ; y++) {
				// Get the pixels at the two places I want to swap
				int a = image.getPixel(x, y);
				int b = image.getPixel(image.getWidth() - x, y);
				
				// swap pixel a and pixel b
				int c = a;
				a = b;
				b = c;
				
				// set the pixel positions to a and b
				image.setPixel(x, y, a);
				image.setPixel(image.getWidth() - x, y, b);
			}
		}
		return image;
	}
```

Flip is very similar to this one, just with respect to `y` instead of `x`.
