package licuadora.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ManejadorGlobalErrores {

    @ControllerAdvice //quiere decir que se va a ejecutar cuando surja un error en el controller
    public class GlobalErrorHandler {
        @ExceptionHandler(PersonalizacionInvalidaException.class) //le decimos que es un manejador para esta excepcion
        @ResponseBody //para que el mensaje lo ponga en el body
        @ResponseStatus(HttpStatus.CONFLICT)
        public String materiaInvalidad(PersonalizacionInvalidaException ex){
            return ex.getTipoError() + ". " + ex.getTipoError();
        }


    }

}
