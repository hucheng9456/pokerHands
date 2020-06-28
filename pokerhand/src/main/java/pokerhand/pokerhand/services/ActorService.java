package pokerhand.pokerhand.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.validation.Valid;

import com.google.gson.JsonParser;
import com.roro.charles.formatter.ErrorResponseForUser;

import org.bytedeco.javacpp.postproc;
import org.roro.Lasfu.component.CustomProperties;
import org.roro.Lasfu.formatter.dishfomatter.OrderAmount;
import org.roro.Lasfu.formatter.dishfomatter.RestOrderList;
import org.roro.Lasfu.formatter.dishfomatter.RestTransaction;
import org.roro.Lasfu.formatter.post.ExternalPostResponse;
import org.roro.Lasfu.formatter.post.PostCreateFormatter;
import org.roro.Lasfu.formatter.post.PostFormatter2;
import org.roro.Lasfu.formatter.post.PostFormatterForPostsInMap;
import org.roro.Lasfu.formatter.post.PostSimplifiedFormatter;
import org.roro.Lasfu.formatter.restaurant.KabuStoreListFormatter;
import org.roro.Lasfu.formatter.restaurant.RestaurantFormatter;
import org.roro.Lasfu.formatter.transaction.OrderFormatter;
import org.roro.Lasfu.formatter.transaction.OrderFormatterForAdmin;
import org.roro.Lasfu.formatter.transaction.OrderFormatterWithDetails;
import org.roro.Lasfu.formatter.transaction.ServiceFormatter;
import org.roro.Lasfu.formatter.user.UserFormatter;
import org.roro.Lasfu.model.Order;
import org.roro.Lasfu.model.Post;
import org.roro.Lasfu.model.Restaurant;
import org.roro.Lasfu.model.Transaction;
import org.roro.Lasfu.model.User;
import org.roro.Lasfu.model.UserPortfolioImage;
import org.roro.Lasfu.repo.DishRepo;
import org.roro.Lasfu.repo.OrderRepo;
import org.roro.Lasfu.repo.PostRepo;
import org.roro.Lasfu.repo.RestaurantRepo;
import org.roro.Lasfu.repo.UserRepo;
import org.roro.Lasfu.services.Interface2.PriceCaculate;
import org.roro.Lasfu.utility.CouponCodeGenerator;
import org.roro.Lasfu.utility.MyBadRequestException;
import org.roro.Lasfu.utility.MyGenericDataHandler;
import org.roro.Lasfu.utility.OrderInfoException;
import org.roro.Lasfu.utility.PostTranslator;
import org.roro.Lasfu.utility.ResourceAuthorizor;
import org.roro.Lasfu.utility.SendOrderAgainException;
import org.roro.Lasfu.utility.VanpeoplePostHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import io.micrometer.core.instrument.Statistic;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ActorService {

	public static Map<String, Object> responseWrap(String[] wrappingNames,Object[] wrappingObjects){
		if(wrappingNames.length != wrappingObjects.length) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "pacaging went wrong");
		}
		Map<String, Object> resMap = new HashMap<String,Object>();
		IntStream.range(0, wrappingNames.length).forEach(i -> {
			resMap.put(wrappingNames[i], wrappingObjects[i]);
		});
		return resMap;
	}
	
	public static Map<String, Object> responseWrap(String wrappingName,Object wrappingObject){
		return new HashMap<String, Object>(){{
			put(wrappingName, wrappingObject);
		}};
	}


}
