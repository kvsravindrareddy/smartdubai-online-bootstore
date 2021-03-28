Step 1: Do the maven build using 
	Linux or Mac: ./mvnw clean install
	Windows: mvnw.cmd clean install
	
Step 2: build the docker file
	docker build -t smartdubai-online-bootstore .

Step 3: Run the application with docker
	docker run --restart=always -d -p 8080:8080 -v /data/veeraassignment:/logs smartdubai-online-bootstore