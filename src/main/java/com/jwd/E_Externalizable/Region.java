package com.jwd.E_Externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Region extends Country implements Externalizable {

    private static final long serialVersionUID = 1L;

    private String climate;
    private Double population;

    public Region() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeUTF(climate);
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {

        super.readExternal(in);
        this.climate = in.readUTF();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }
}

