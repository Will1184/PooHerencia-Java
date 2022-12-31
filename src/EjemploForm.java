import org.brandongomez.form.elementos.*;
import org.brandongomez.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class EjemploForm {
    public static void main(String[] args) {
        InputForm username=new InputForm("username");
        InputForm password=new InputForm("username","password");
        InputForm email=new InputForm("email","email");
        InputForm edad=new InputForm("edad","number");

        TextareaForm experencia=new TextareaForm("exp",5,8);

        SelectForm lenguaje=new SelectForm("lenguaje");

                lenguaje.addOpcion(new Opcion("1","Java"))
                .addOpcion(new Opcion("2","Python").setSelected())
                        .addOpcion(new Opcion("3","JavaScript"))
                        .addOpcion(new Opcion("4","TypeScript"))
                        .addOpcion(new Opcion("5","PHP"));

        ElementoForm saludar = new ElementoForm("Saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"
                        + this.nombre+"' value\""
                        +this.valor+"\">";
            }
        };
        saludar.setValor("Hola que tal este campo esta deshabilitado");
        username.setValor("john,doe");
        password.setValor("a1b2c3");
        email.setValor("john.doe@correo.com");
        edad.setValor("28");
        experencia.setValor("... mas de 10 años de experiencia ...");

        List<ElementoForm> elementos= Arrays.asList(username,
                password,
                email,
                edad,
                experencia,
                lenguaje,
                saludar);

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println();
        });
    }

}
