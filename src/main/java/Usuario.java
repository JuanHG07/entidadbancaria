public class Usuario {

    private String nombre;
    private String direccion;
    private String cedula;
    private String correo;
    private String contrasenia;

    public Usuario(String nombre, String direccion, String cedula, String correo, String contrasenia) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void recargarBilletera(float ingreso) {

    }




        // Método para recargar la billetera
        public void recargarBilletera(float ingreso) {
            private float saldo; // Variable para almacenar el saldo actual
            if (ingreso <= 0) {
                throw new IllegalArgumentException("El monto a recargar debe ser positivo");
            }
            saldo += ingreso;
            return; saldo;
        }


    }
}



