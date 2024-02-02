package br.com.alura.desafiofipe.constant;

import java.math.BigDecimal;

public enum Vehicle {
    Carro{
        @Override
        public String getVehicleType() {
            return "carros";
        }
    }

    , Moto {
        @Override
        public String getVehicleType() {
            return "motos";
        }
    }, Caminhão {
        @Override
        public String getVehicleType() {
            return "caminhoes";
        }
    };

    public abstract String getVehicleType();
}
