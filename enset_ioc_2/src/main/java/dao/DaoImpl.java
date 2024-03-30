package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("version base de données");
        double tmp=Math.random()*20;

        return tmp;
    }

    public void setDao(DaoImpl dao) {
    }
}
