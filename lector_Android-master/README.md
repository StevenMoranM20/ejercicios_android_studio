# LectorCedulasCR
Proyecto de Android Studio de app para lectura de cédulas de identificación de Costa Rica.

El código de barras de las Cédulas Costaricenses son de tipo PDF417(https://en.wikipedia.org/wiki/PDF417), y se encuentran codificadas por un algoritmo XOR(https://en.wikipedia.org/wiki/XOR_cipher), este tipo de codificación tiene una llave, en este caso es de 17 entradas pero puede variar.

Este proyecto esta basado en el ejemplo https://github.com/journeyapps/zxing-android-embedded

En caso de algún error no duden en reportarlo, pronto estare subiendo un repositorio para el framework IONICv2, esto para que sea multiplataforma, ademas de agregar documentación interna a este repositorio.



#Código
El archivo encargado de la decodificación del código se llama CedulaCR, este es una Classe de java que se conforma por la llave anteriormente mencionada y una función llamada 'parse' que efectua la decodificación, además esta obtiene los trozos de información y lo devulve como una clase _dummy_ para un manejo mas sencillo de la información obtenida.

Código de la clase CedulaCR

```code
public class CedulaCR {
    private static byte[] keysArray = new byte[]{
            (byte)0x27,
            (byte)0x30,
            (byte)0x04,
            (byte)0xA0,
            (byte)0x00,
            (byte)0x0F,
            (byte)0x93,
            (byte)0x12,
            (byte)0xA0,
            (byte)0xD1,
            (byte)0x33,
            (byte)0xE0,
            (byte)0x03,
            (byte)0xD0,
            (byte)0x00,
            (byte)0xDf,
            (byte)0x00
    };

    public static Persona parse(byte[] raw){
        String d= "";
        int j = 0;
        for (int i = 0; i < raw.length; i++) {
            if (j == 17) {
                j = 0;
            }
            char c = (char) (keysArray[j] ^ ((char) (raw[i])));
            if((c+"").matches("^[a-zA-Z0-9]*$")){
                d += c;
            }else{
                d +=' ';
            }
            j ++;
        }
        Persona p = new Persona();
        try {
            p.setCedula(d.substring(0, 9).trim());
            p.setApellido1(d.substring(9, 35).trim());
            p.setApellido2(d.substring(35, 61).trim());
            p.setNombre(d.substring(61, 91).trim());
            p.setGenero(d.charAt(91));
            p.setFechaNacimiento(d.substring(92, 96)+"-"+d.substring(96, 98)+"-"+d.substring(98, 100));
            p.setFechaVencimiento(d.substring(100, 104)+"-"+d.substring(104, 106)+"-"+d.substring(106, 108));
        }catch (Exception e){
            p = null;
	}
	retunr p;
    }
```
