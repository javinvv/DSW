package Animales.animal.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "animals")
public class animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "El nombre no puede estar en blanco")
    @Size(min = 3, max = 15, message = "El nombre ha de tener entre 3 y 15 caracteres")
    private String nombre;
    @Min(value = 0, message = "La edad media ha de ser un número positivo")
    private int vida;
    private boolean extinto;

    public animal() {}

    public animal(String nombre, int vida, boolean extinto){
        this.nombre = nombre;
        this.vida = vida;
        this.extinto = extinto;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getVida(){
        return vida;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    public boolean getExtinto(){
        return extinto;
    }
    public void setExtinto(boolean extinto){
        this.extinto = extinto;
    }
}