# Bangkit-MunculLagi
The project called "Raja Tawar" is an application developed using Kotlin as a programming language for Front End, PHP as a programming language for Back End. The main feature that we provide from this application is an auction or bidding approach in marketplace. Unlike the other, our marketplace focus on bidding feature to gain an exposure for the customers who look for product or custom product. This kind of behaviour also appear in social media like Facebook. They upload or share their desired product to facebook's seller groups, hope if they will find what they need.

# Cloud GCP
- Create project
- Create instance
- Create database in SQL
- Create you table
- Our project use VM for get API, so use Compute Engine to create VM
- Then prepare your VM by updating, and download necessary program
- Then use .php file to get the API

# Machine Learning
Machine learning role in this application is to provide search matching or optimize the application's search engine using MobileNet and BERT (Transformer)
- Dataset consists of: 1) Title to search or/and 2) Image to search
- Input data text is transformed using BERT into text embeddings
- Input data image is transformed using MobileNet into image embeddings
- We normalize the embeddings by the mean (Average Max Pooling)
- We predicts the similarity between one embeddings and other list of embeddings (trained model)
- The output of the model is list of matches text or images
