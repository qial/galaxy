package net.qial.galaxy.world;

import java.security.MessageDigest;

public class SeedUtil {
	private static MessageDigest md;
//TODO fix this file
	public static byte[] getBytes(Object o) {
		if(md == null) {
			initMd();
		}

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
	
	public static int[] getSeeds(Object o) {
		byte[] arr = getBytes(o);
		int[] ints = new int[arr.length];
		// add 128 to everything so its unsigned
		for(int i = 0; i < arr.length; i++) {
			ints[i]=((int)arr[i])+128;
		}
		return ints;
	}
	
	private static void initMd() {
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (Exception e) {
			// well we're fucked
		}
	}
	
	public static String toString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		sb.append("byte[").append(bytes.length).append("],[");
		for(int i = 0; i < bytes.length; i++) {
			if(i != 0) {
				sb.append(",");
			}
			sb.append((int)bytes[i]);
		}
		sb.append("]");
		return sb.toString();
	}

}
