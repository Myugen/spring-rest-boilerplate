package ninja.mcabsan.boilerplate.controller.v1.rest.common;

import javax.transaction.Transactional;

@Transactional(rollbackOn = Exception.class)
public abstract class RestApiV1Controller {
}
