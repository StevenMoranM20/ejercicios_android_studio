package com.ejercicio.tds_noct_2022_1_orlasic.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.ejercicio.tds_noct_2022_1_orlasic.conexion.Conexion;
import com.ejercicio.tds_noct_2022_1_orlasic.controller.Login;
import com.ejercicio.tds_noct_2022_1_orlasic.controller.UserRegister;

public class Usuario {

    private int idUsuario;
    private String nombre;
    private  String correo;
    private  String clave;
    private int idTipoUsuario;
    private  int  estado;
    // constructor
    public  Usuario(){
        this.idTipoUsuario=0;
        this.nombre="";
        this.correo="";
        this.clave="";
        this.idTipoUsuario=0;
        this.estado=1;

    }
    // get y set

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    //ToString


    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", idTipoUsuario=" + idTipoUsuario +
                ", estado=" + estado +
                '}';
    }
    // metod login
    public boolean login(Login context){
        // variable que permite la respuesta si las credinciales fueron /no corre.
        boolean respuesta = false;
        //Instanciamos un objeto de tipo conexion
        Conexion conexion = new Conexion(context);
        // Instancio un objeto de scritura y lectura en la base de datos
        SQLiteDatabase consulta = conexion.getWritableDatabase();
        // prepara la consulta a la base de datos
        Cursor registro = consulta.rawQuery("SELECT correo, clave FROM tb_usuario WHERE id_tipo_usuario = 2 AND estado = 1", null);
        // recorrer un cursor
        if (registro.moveToFirst()){
            // Ciclo para evaluar
            do {
                //preguntamos si el objeto usuario exixte en la base de datos(tb_usuario)
                if (registro.getString(0).equals(this.correo) && registro.getString(1).equals(this.clave)){
                    // la respuesta cambia (el correo y clave es correcto)
                    Toast toast1 = Toast.makeText(context, "otro", Toast.LENGTH_SHORT);
                    toast1.show();

                    respuesta =true;
                }
            }while (registro.moveToNext());
        }

        return respuesta;
    }
    // metodo Crear cuenta (Cliente)
    public boolean crear(UserRegister context){
        // variable de tipo respuesta
        boolean respuesta = false;
        // intaciamos un objeto de tipo conexion
        Conexion conexion = new Conexion(context);
        //Abriamos la base de datos para modo lectur/escritura
        SQLiteDatabase consulta = conexion.getWritableDatabase();
        //Prepradamos la consulta para la insercion
        ContentValues registro = new ContentValues();
        //Refrenciar los campos con la informacion a enviar
        registro.put("nombre", this.nombre);
        registro.put("correo", this.correo);
        registro.put("clave", this.clave);
        registro.put("id_tipo_usuario", 2);
        registro.put("estado", 1);
        //Insertamos el registro
        if((consulta.insert("tb_usuario", null, registro)>0)){
            //Respuesta cambiar a true
            respuesta = true;
        }
        return respuesta;

    }
    // metodo recuperar cuenta
    //public boolean recuperar()


}


