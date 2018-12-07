package ru.gubernik.company.dao.office;

import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Office;
import ru.gubernik.company.view.source.ResultView;

import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {


    @Override
    public List<Office> offices(Integer id) {
        return null;
    }

    @Override
    public Office get(Integer id) {
        return null;
    }

    @Override
    public ResultView update(Office view) {
        return null;
    }

    @Override
    public ResultView save(Office view) {
        return null;
    }
}
