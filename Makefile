.PHONY: help setup backend-build backend-run backend-test mobile-install mobile-start mobile-lint lint test clean docker-up docker-down

# Colors for output
BLUE := \033[0;34m
NC := \033[0m # No Color

help: ## Show this help message
	@echo '$(BLUE)Available commands:$(NC)'
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "  \033[36m%-20s\033[0m %s\n", $$1, $$2}'

setup: ## Initial project setup
	@echo "$(BLUE)Setting up project...$(NC)"
	@chmod +x scripts/*.sh
	@./scripts/setup.sh

# Backend commands
backend-build: ## Build backend application
	@echo "$(BLUE)Building backend...$(NC)"
	@cd backend && ./gradlew build

backend-run: ## Run backend application
	@echo "$(BLUE)Starting backend...$(NC)"
	@cd backend && ./gradlew bootRun

backend-test: ## Run backend tests
	@echo "$(BLUE)Running backend tests...$(NC)"
	@cd backend && ./gradlew test

backend-lint: ## Check backend code style
	@echo "$(BLUE)Checking backend code style...$(NC)"
	@cd backend && ./gradlew ktlintCheck

backend-format: ## Format backend code
	@echo "$(BLUE)Formatting backend code...$(NC)"
	@cd backend && ./gradlew ktlintFormat

backend-clean: ## Clean backend build
	@echo "$(BLUE)Cleaning backend...$(NC)"
	@cd backend && ./gradlew clean

# Mobile commands
mobile-install: ## Install mobile dependencies
	@echo "$(BLUE)Installing mobile dependencies...$(NC)"
	@cd mobile && npm install

mobile-start: ## Start mobile development server
	@echo "$(BLUE)Starting mobile app...$(NC)"
	@cd mobile && npm start

mobile-lint: ## Lint mobile code
	@echo "$(BLUE)Linting mobile code...$(NC)"
	@cd mobile && npm run lint

mobile-format: ## Format mobile code
	@echo "$(BLUE)Formatting mobile code...$(NC)"
	@cd mobile && npm run format

mobile-test: ## Run mobile tests
	@echo "$(BLUE)Running mobile tests...$(NC)"
	@cd mobile && npm test

mobile-type-check: ## Type check mobile code
	@echo "$(BLUE)Type checking mobile code...$(NC)"
	@cd mobile && npm run type-check

mobile-clean: ## Clean mobile build
	@echo "$(BLUE)Cleaning mobile...$(NC)"
	@cd mobile && rm -rf node_modules .expo

# Combined commands
lint: backend-lint mobile-lint ## Run all linting

test: backend-test mobile-test ## Run all tests

clean: backend-clean mobile-clean ## Clean all builds

install: backend-build mobile-install ## Install all dependencies

# Docker commands
docker-up: ## Start Docker containers
	@echo "$(BLUE)Starting Docker containers...$(NC)"
	@docker-compose up -d

docker-down: ## Stop Docker containers
	@echo "$(BLUE)Stopping Docker containers...$(NC)"
	@docker-compose down

docker-logs: ## Show Docker logs
	@docker-compose logs -f

docker-clean: ## Remove Docker containers and volumes
	@echo "$(BLUE)Cleaning Docker resources...$(NC)"
	@docker-compose down -v

# Development
dev-backend: ## Start backend in development mode
	@make docker-up
	@make backend-run

dev-mobile: ## Start mobile in development mode
	@make mobile-start

dev: ## Start full development environment
	@make docker-up
	@echo "$(BLUE)Starting development environment...$(NC)"
	@echo "Run 'make backend-run' in one terminal"
	@echo "Run 'make mobile-start' in another terminal"