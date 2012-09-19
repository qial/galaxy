package net.qial.galaxy.world;

import java.security.MessageDigest;

public class SeedUtil {
	private static MessageDigest md;
	private static byte[] getSeedFor(Object o) {
		String msg = o.toString();
		byte[] bytes = md.digest(msg.getBytes());
		return bytes;
	}
}
