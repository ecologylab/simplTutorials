package tutorials.multiformat.testcases.circle;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import ecologylab.serialization.*;
import ecologylab.serialization.tlv.Utils;

public class Circle extends ElementState
{
	@simpl_scalar
	@simpl_hints(Hint.XML_LEAF)
	private int		radius;

	@simpl_composite
	private Point	center;

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
		
		Circle data = (Circle) TranslationScope.get("circle", Circle.class, Point.class).deserializeCharSequence(sb, FORMAT.JSON);
		
		System.out.println();
		data.serialize(System.out, FORMAT.XML);
		System.out.println();
		data.serialize(System.out, FORMAT.JSON);
		
				
		//circle.serialize(System.out, Format.TLV);
//		circle.serializeToJSON(System.out);
//		
//		System.out.println();
//		System.out.println();
//		
//		TranslationScope.get("circleScope", Circle.class, Point.class);
//		
//		
//		ByteArrayOutputStream stream = new ByteArrayOutputStream();
//		DataOutputStream test1 = new DataOutputStream(stream);
//		
//		circle.serialize(test1, FORMAT.TLV);
//		circle.serialize(System.out, FORMAT.JSON);
		
//		Utils.writeHex(System.out, stream.toByteArray());				
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
