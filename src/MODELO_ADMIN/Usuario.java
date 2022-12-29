package MODELO_ADMIN;

/**
 *
 * @author EL CAPO
 */
public class Usuario{

    private int id;
    private String tipoDocumento;
    private String DNI;
    private String nombre;
    private String apellido;
    private String telefono;
    private String usuario;
    private String contraseña;
    private String confirmarContraseña;
    private String rol;
    private String correo;
    private String relacion_id;
    private String direccion;
    private String codigo;
    private String tiempocodigo;
    private String grado;
    private String seccion;
    private String horario;
    private String nombre_curso;
    private String peridodo;
    private Float nota1;
    private Float nota2;
    private Float nota3;
    private Float nota4;
    private Float prome;
    private String comentario;
    private String dia;

    public Usuario() {
    }

    public Usuario(int id, String tipoDocumento, String DNI, String nombre, String apellido, String telefono, String usuario, String contraseña, String confirmarContraseña, String rol, String correo, String relacion_id, String direccion, String codigo, String tiempocodigo, String grado, String seccion, String horario, String nombre_curso, String peridodo, Float nota1, Float nota2, Float nota3, Float nota4, Float prome, String comentario, String dia) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.confirmarContraseña = confirmarContraseña;
        this.rol = rol;
        this.correo = correo;
        this.relacion_id = relacion_id;
        this.direccion = direccion;
        this.codigo = codigo;
        this.tiempocodigo = tiempocodigo;
        this.grado = grado;
        this.seccion = seccion;
        this.horario = horario;
        this.nombre_curso = nombre_curso;
        this.peridodo = peridodo;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.prome = prome;
        this.comentario = comentario;
        this.dia = dia;
    }

   

    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the DNI
     */
  

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the Usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getConfirmarContraseña() {
        return confirmarContraseña;
    }

    public void setConfirmarContraseña(String confirmarContraseña) {
        this.confirmarContraseña = confirmarContraseña;
    }
    

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }     

    public String getRelacion_id() {
        return relacion_id;
    }

    public void setRelacion_id(String relacion_id) {
        this.relacion_id = relacion_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

   

    public String getTiempocodigo() {
        return tiempocodigo;
    }

    public void setTiempocodigo(String tiempocodigo) {
        this.tiempocodigo = tiempocodigo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public Float getNota1() {
        return nota1;
    }

    public void setNota1(Float nota1) {
        this.nota1 = nota1;
    }

    public Float getNota2() {
        return nota2;
    }

    public void setNota2(Float nota2) {
        this.nota2 = nota2;
    }

    public Float getNota3() {
        return nota3;
    }

    public void setNota3(Float nota3) {
        this.nota3 = nota3;
    }

    public Float getNota4() {
        return nota4;
    }

    public void setNota4(Float nota4) {
        this.nota4 = nota4;
    }

    public Float getProme() {
        return prome;
    }

    public void setProme(Float prome) {
        this.prome = prome;
    }

   



    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getPeridodo() {
        return peridodo;
    }

    public void setPeridodo(String peridodo) {
        this.peridodo = peridodo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

   
    
    
}
