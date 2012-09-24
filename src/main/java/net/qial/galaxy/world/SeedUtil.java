package net.qial.galaxy.world;

import java.security.MessageDigest;

public class SeedUtil {
	private static MessageDigest md;
	public static byte[] getSeedFor(Object o) {
		loadMd();
		String msg = o.toString();
		byte[] bytes = md.digest(msg.getBytes());
		return bytes;
	}
	private static void loadMd() {
		if(md == null) {
			try {
				md = MessageDigest.getInstance("SHA-1");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
