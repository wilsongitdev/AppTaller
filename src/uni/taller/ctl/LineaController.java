package uni.taller.ctl;

import java.util.List;
import uni.taller.dao.LineaDao;
import uni.taller.dto.Linea;

public class LineaController {

    LineaDao dao;

    public LineaController() {
        dao = new LineaDao();
    }

    public List<Linea> LineaListar() throws Exception {
        return dao.readAll();
    }

}
