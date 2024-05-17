# URL Shortener Project

This URL Shortener was the first project I ever created with Spring Boot. I created it alongside my team of apprentices. It works by taking in a URL, running it through an MD5 hashing algorithm, and returning a short URL. The short URL can be used to retrieve the original URL.

## Technologies Used

- Git
- Jira
- Spring Boot CRUD application
- Postman
- APIs

## What I Learned

Some additional and important things I learned were working as a team, writing Jira tickets, and how important having and being a good teammate is. The emphasis on teamwork is paramount.

## What I Found Interesting

My favorite piece of code in the entire project is the `MD5Hash` class.

```java
public class MD5Hash {
    public static String MD5HashingMethod(String originalUrl) {
        String finalShortUrl = "";
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5"); // Create an instance of Message Digest. Message Digests are secure one-way hash functions
            // it outputs a fixed-length hash value.
            // 'getInstance' returns a message digest object which implements the specified algorithm (md5)
            byte[] inputBytes = originalUrl.getBytes();    // convert original url to bytes
            md.update(inputBytes);                         // update the message digest with the input bytes
            byte[] md5Bytes = md.digest();                 // Calculate the MD5 hash, returns an array of bytes 'md5Bytes'
            // digest() performs final hashing computations.

            String base64Encoded = Base64.getEncoder().encodeToString(md5Bytes);   // encodes the byte array 'md5Bytes' to base64
            finalShortUrl = base64Encoded.substring(0, 7);    // Substring of base64Encoded with the first 7 characters

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;

        }
        return finalShortUrl;
    }
}
```


Looking back at it now, it is not that complicated. However, when we were first building this, it was the most complicated piece of code I had ever seen. When we were deciding on who will do what parts of the project, I hesitated to put up my hand for the MD5 algorithm. That is when my teammate, Sean, put his hand up and took it on. Not because it was easy or because he was an extremely intelligent person. He did it because it was something that needed to be done. That experience has shaped me as a developer.

# Update
This project is now hosted on Google Cloud's Cloud Run. Here is a link to how I did it: [Hosting Spring Boot App with Cloud Run - Continuous Deployment](https://conorlynam.wordpress.com/2024/04/11/hosting-springboot-app-with-cloud-run-continuous-deployment/)
![GoogleCloudDiagram.png](..%2F..%2FOneDrive%20-%20Zinkworks%2FDesktop%2FGoogleCloudDiagram.png)