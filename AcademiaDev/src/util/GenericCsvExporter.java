package util;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class GenericCsvExporter {
	public static String export(List<?> objects, List<String> fields) {
		if (objects.isEmpty())
			return "";

		StringBuilder sb = new StringBuilder(String.join(";", fields) + "\n");

		for (Object obj : objects) {
			String row = fields.stream().map(f -> {
				try {
					Field field = getFieldAnywhere(obj.getClass(), f.trim());
					field.setAccessible(true);
					Object val = field.get(obj);
					return val != null ? val.toString() : "";
				} catch (Exception e) {
					return "N/A";
				}
			}).collect(Collectors.joining(";"));
			sb.append(row).append("\n");
		}
		return sb.toString();
	}

	private static Field getFieldAnywhere(Class<?> clazz, String name) throws NoSuchFieldException {
		try {
			return clazz.getDeclaredField(name);
		} catch (NoSuchFieldException e) {
			if (clazz.getSuperclass() != null)
				return getFieldAnywhere(clazz.getSuperclass(), name);
			throw e;
		}
	}
}
