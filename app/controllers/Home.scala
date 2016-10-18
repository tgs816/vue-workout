package controllers

import javax.inject.Inject

import play.api.i18n.{MessagesApi, I18nSupport}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

class Home @Inject()(val messagesApi: MessagesApi, currencyDao: dao.currencyDao) extends Controller with I18nSupport {

  def index = Action { implicit request =>
    Ok(views.html.index(forms.Currency.currency(isAdd = true)))
  }

  def currency = Action { implicit request =>
    //Ok(views.html.currency(currencyDao.select))
    Ok(Json.toJson(currencyDao.select))
  }

  def currencyAddPage = Action { implicit request =>
    Ok(views.html.currencyAdd(forms.Currency.currency(isAdd = true)))
  }

  def currencyAdd = Action { implicit request =>
    forms.Currency.currency(isAdd = true).bindFromRequest.fold(
      formWithErrors => BadRequest(formWithErrors.errorsAsJson), {
      case currencyForm => currencyDao.insert(currencyForm) match {
        case 1 => Ok(views.html.currency(currencyDao.select))
        case _ => BadRequest
      }
    }
    )
  }

  def currencyEditPage(id: String) = Action { implicit request =>
    currencyDao.select(id).map { currency =>
      Ok(views.html.currencyEdit(forms.Currency.currency(isAdd=false).fill(currency)))
    }.getOrElse(BadRequest)
  }

  def currencyEdit = Action { implicit request =>
    forms.Currency.currency(isAdd = false).bindFromRequest.fold(
      formWithErrors => BadRequest(formWithErrors.errorsAsJson), {
      case currencyForm => currencyDao.update(currencyForm) match {
        case 1 => Ok(views.html.currency(currencyDao.select))
        case _ => BadRequest
      }
    }
    )
  }

  def currencyDelete(id: String) = Action { implicit  request =>
    currencyDao.delete(id) match {
      case 1 => Ok(views.html.currency(currencyDao.select))
      case _ => BadRequest
    }
  }

  def home = Action { implicit request =>
    Ok(views.html.home())

  }
}
























