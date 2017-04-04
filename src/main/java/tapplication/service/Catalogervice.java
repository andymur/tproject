package tapplication.service;

import org.springframework.ui.Model;
import tapplication.exceptions.NotFoundException;

/**
 * Created by alexpench on 04.04.17.
 */
public interface Catalogervice {
    Object preparePage(Model model, Long categoryid) throws NotFoundException;
}
