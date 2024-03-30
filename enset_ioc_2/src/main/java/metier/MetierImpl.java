package metier;
import ext.DaoImpl2;
import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    @Autowired
    @Qualifier("dao")
    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double tmp= dao.getData();
        return 0;
    }


    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
