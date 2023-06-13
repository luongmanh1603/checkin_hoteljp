package factory;

import DAOpattern.IRepository;
import DAOpattern.OrderRepository;
import enums.RepositoryType;

public class RepositoryFactory {
    public static IRepository createRepositoryInstance(RepositoryType type){
        if (type==RepositoryType.Order)
            return OrderRepository.getInstance();
      return null;
    }
}
