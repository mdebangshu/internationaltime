package com.lightweight.internationaltime;

import java.util.function.Function;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import com.lightweight.internationaltime.function.WorldTimeFunction;
import com.lightweight.internationaltime.model.Country;
import com.lightweight.internationaltime.model.WorldTime;

@SpringBootApplication
public class InternationaltimeApplication implements ApplicationContextInitializer<GenericApplicationContext> {

	public static void main(String[] args) throws Exception {
		FunctionalSpringApplication.run(InternationaltimeApplication.class, args);
	}
	
	public WorldTimeFunction function() {
		return new WorldTimeFunction();
	}
	
	@Override
	public void initialize(GenericApplicationContext context) {
		context.registerBean("function", FunctionRegistration.class,
				() -> new FunctionRegistration<Function<Country, WorldTime>>(function())
						.type(FunctionType.from(Country.class).to(WorldTime.class).getType()));
		
	}
}