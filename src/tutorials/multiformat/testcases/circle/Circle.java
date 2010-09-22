package tutorials.multiformat.testcases.circle;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;


import translators.cocoa.CocoaTranslator;


import ecologylab.serialization.*;
import ecologylab.serialization.tlv.TLVParser;
import ecologylab.serialization.tlv.Utils;

/**
 * a simple example for simpl serialization
 * declares a class Circle
 * @author nabeelshahzad
 *
 */
public class Circle extends ElementState
{
	/**
	 * attribute defines the the radius of the circle
	 */
	@simpl_scalar
	@simpl_hints(Hint.XML_LEAF)
	private int		radius;

	/**
	 * Composite object of type Point 
	 * defines the 
	 */
	@simpl_composite
	private Point	center;

	/**
	 * attribute field defines the area of the circle 
	 */
	@simpl_scalar
	@simpl_hints(Hint.XML_LEAF)
	private int		area;

	public Circle()
	{

	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	public int getRadius()
	{
		return radius;
	}

	public void setCenter(Point center)
	{
		this.center = center;
	}

	public Point getCenter()
	{
		return center;
	}

	public static void main(String args[]) throws SIMPLTranslationException
	{
		final StringBuilder sb = new StringBuilder();
		OutputStream outputStream = new OutputStream()
		{
			@Override
			public void write(int b) throws IOException
			{
				sb.append((char) b);
			}
		};
		
		TranslationScope circleTranslationScope = TranslationScope.get("circle", Circle.class, Point.class);
		
		Point center = new Point();
		center.setX(2);
		center.setY(3);
		
		Circle circle = new Circle();
		circle.setRadius(10);
		circle.setCenter(center);
		circle.setArea(100);
		
		circle.serialize(outputStream, FORMAT.XML);
		System.out.println(sb);
		
		
		sb.delete(0, sb.length());
		
		circle.serialize(outputStream, FORMAT.JSON);
		System.out.println(sb);
		
		Circle data = (Circle) circleTranslationScope.deserializeCharSequence(sb, FORMAT.JSON);
		
		System.out.println();
		data.serialize(System.out, FORMAT.XML);
		System.out.println();
		data.serialize(System.out, FORMAT.JSON);
		
		System.out.println();
		System.out.println();
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream test = new DataOutputStream(byteArrayOutputStream);
		
		circle.serialize(test, FORMAT.TLV);
		
		Utils.writeHex(System.out, byteArrayOutputStream.toByteArray());		

		System.out.println();
		System.out.println();
		
		Circle deCircle = (Circle) circleTranslationScope.deserializeByteArray(byteArrayOutputStream.toByteArray(), FORMAT.TLV);	
		deCircle.serialize(System.out, FORMAT.XML);

	}

	public void setArea(int area)
	{
		this.area = area;
	}

	public int getArea()
	{
		return area;
	}
}
