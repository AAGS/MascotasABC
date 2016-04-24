
package com.abc.mascotas.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.abc.mascotas.excepciones.EncripcionNoValidaException;

public class UtilidadesEncripcionAES {

	private static final String LLAVE_ENCRIPCION = "DFyjpewErsCpRrFa";

	private UtilidadesEncripcionAES() {
	}

	public static String encriptar(String texto) throws EncripcionNoValidaException {
		Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
		byte[] binarioEncriptado;
		try {
			binarioEncriptado = cipher.doFinal(texto.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			throw new EncripcionNoValidaException("El proceso de encripcion ha sido invalido");
		}

		return Base64.encodeBase64String(binarioEncriptado);
	}

	public static String desencriptar(String encriptado) throws EncripcionNoValidaException {
		Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
		byte[] binarioPlano;
		try {
			binarioPlano = cipher.doFinal(Base64.decodeBase64(encriptado));
			return new String(binarioPlano);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			throw new EncripcionNoValidaException("El proceso de desencripcion ha sido invalido");
		}
	}

	private static Cipher getCipher(int cipherMode) throws EncripcionNoValidaException {

		String encryptionAlgorithm = "AES";

		try {
			SecretKeySpec keySpecification = new SecretKeySpec(LLAVE_ENCRIPCION.getBytes("UTF-8"), encryptionAlgorithm);
			Cipher cipher;
			cipher = Cipher.getInstance(encryptionAlgorithm);
			cipher.init(cipherMode, keySpecification);
			return cipher;
		} catch (UnsupportedEncodingException | 
				 NoSuchAlgorithmException | 
				 NoSuchPaddingException | 
				 InvalidKeyException e) {
			throw new EncripcionNoValidaException("El proceso de encripcion ha sido invalido");
		}
	}

	public static void main(String[] args) throws Exception {
		String encriptado = UtilidadesEncripcionAES.encriptar("usuario1");
		System.out.println("Encriptado " + encriptado);
		System.out.println("Desencriptado " + UtilidadesEncripcionAES.desencriptar(encriptado));
	}
}