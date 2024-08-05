package com.ru.corporatedatastorage.scheduler;

import com.ru.corporatedatastorage.rest.AccountRestService;
import com.ru.corporatedatastorage.rest.ContractRestService;
import com.ru.corporatedatastorage.rest.EmployeeRestService;
import com.ru.corporatedatastorage.rest.PartnerRestService;
import com.ru.corporatedatastorage.rest.ProductRestService;
import com.ru.corporatedatastorage.rest.PurchaseRestService;
import com.ru.corporatedatastorage.rest.RequestRestService;
import com.ru.corporatedatastorage.rest.UserRestService;
import com.ru.corporatedatastorage.service.AccountHandler;
import com.ru.corporatedatastorage.service.ContractHandler;
import com.ru.corporatedatastorage.service.EmployeeHandler;
import com.ru.corporatedatastorage.service.PartnerHandler;
import com.ru.corporatedatastorage.service.ProductHandler;
import com.ru.corporatedatastorage.service.PurchaseHandler;
import com.ru.corporatedatastorage.service.RequestHandler;
import com.ru.corporatedatastorage.service.UserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataScheduler {

	private final AccountHandler accountHandler;
	private final AccountRestService accountRestService;

	private final ContractHandler contractHandler;
	private final ContractRestService contractRestService;

	private final EmployeeHandler employeeHandler;
	private final EmployeeRestService employeeRestService;

	private final PartnerHandler partnerHandler;
	private final PartnerRestService partnerRestService;

	private final ProductHandler productHandler;
	private final ProductRestService productRestService;

	private final PurchaseHandler purchaseHandler;
	private final PurchaseRestService purchaseRestService;

	private final RequestHandler requestHandler;
	private final RequestRestService requestRestService;

	private final UserHandler userHandler;
	private final UserRestService userRestService;

	@Scheduled(
			cron = "${scheduled.data-migration.cron}",
			zone = "${scheduled.timezone}"
	)
	public void migrateAllData() {
		userHandler.migrate(userRestService.getUsers());
		requestHandler.migrate(requestRestService.getRequests());
		partnerHandler.migrate(partnerRestService.getPartners());
		productHandler.migrate(productRestService.getProducts());
		employeeHandler.migrate(employeeRestService.getEmployees());
		accountHandler.migrate(accountRestService.getAccounts());
		contractHandler.migrate(contractRestService.getContracts());
		purchaseHandler.migrate(purchaseRestService.getPurchases());
	}

}
