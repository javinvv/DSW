package Animales.animal.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animals")
public class animal {
    private int id;
    private String nombre;
    private int vida;
    private boolean extinto;
    public animal() {
    }
    public animal(int id, String nombre, int vida, boolean extinto){
        this.id = id;
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
