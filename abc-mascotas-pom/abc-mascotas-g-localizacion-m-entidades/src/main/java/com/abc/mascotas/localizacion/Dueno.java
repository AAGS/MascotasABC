package com.abc.mascotas.localizacion;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="DUENO")
public class Dueno extends Usuario{

}
