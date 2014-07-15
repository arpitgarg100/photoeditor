Photo Editor
===========

- Make a package named "PhotoEditor".
- In the PhotoEditor package, make three classes - Photo, PhotoEffect, and PhotoEditor. Delete all the code that Eclipse generates in them.
- Copy and paste the corresponding files from this repository into the three files.

## Making a new effect

First, make a function for it that takes in a `Photo` object and returns a `Photo` object.

```java
public static Photo foo(Photo image) {
  return image;
}
```

Add your effect to the menu by modifying the `getMenu` function. For example, if I want to add my filter `Foo`, I will add it as a String to the list.

```java
  public static String[][] getMenu() {
		return new String[][] {
			{ "Size", 		/* Contents */ "Half", "Rotate", "Flip", "Mirror" },
			{ "Color", 		/* Contents */ "Foo", "Blur", "Taylor Swift", "Example", "Instagram", "Funky", "Grayscale", "Brighten", "Darken" },
			{ "Combine", 	/* Contents */ "Size To", "Merge", "Chromakey" }
		};
	}
```

Add the effect to the `process` function.

```java
  public static Photo process(String cmd, Photo source, Photo background) {
		try {
			...
			if (cmd.equals("Foo")) {			return PhotoEffect.foo(source);				}
			...
		}
		catch (ArrayIndexOutOfBoundsException e) {
			PhotoEditor.failure("Array index went out of bounds.");
			PhotoEditor.failure(e.getMessage());
			return null;
		}
		return source;
	}
```
