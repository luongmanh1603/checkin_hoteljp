package DAOpattern;

import hotel.Order;

import java.util.ArrayList;

public interface IRepository <O> {
   ArrayList<O> getAll();
    Boolean create (O o);

    Boolean update(O o);

    Boolean delete(O o);
    Order find(Integer id);
}
