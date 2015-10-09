/*
 * Copyright 2015 Masahiro Okubo HDE,Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;

import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import jp.co.hde.mail.ses.CMCAmazonClient;

public class CMCAmazonClientSample {
 
    // Replace with your "From" address. This address must be verified.
    static final String FROM = "SENDER@EXAMPLE.COM";
    
    // Replace with a "To" address. If your account is still in the
    // sandbox, this address must be verified.
    static final String TO = "RECIPIENT@EXAMPLE.COM";
    
    static final String BODY = "This email was sent through Amazon SES by using the AWS SDK for Java.";
    
    static final String SUBJECT = "Amazon SES test (AWS SDK for Java)";

    public static void main(String[] args) throws IOException {     
                
        // Construct an object to contain the recipient address.
        Destination destination = new Destination().withToAddresses(new String[]{TO});
        
        // Create the subject and body of the message.
        Content subject = new Content().withData(SUBJECT);
        Content textBody = new Content().withData(BODY); 
        Body body = new Body().withText(textBody);
        
        // Create a message with the specified subject and body.
        Message message = new Message().withSubject(subject).withBody(body);
        
        // Assemble the email.
        SendEmailRequest request = new SendEmailRequest().withSource(FROM).withDestination(destination).withMessage(message);

        try
        {        
            System.out.println("Attempting to send an email through Amazon SES by using the AWS SDK for Java...");
/*=============================================================================
 * 以下ソースコードを本ライブラリに置き換えます。
 *
            // Instantiate an Amazon SES client, which will make the service call. The service call requires your AWS credentials. 
            // Because we're not providing an argument when instantiating the client, the SDK will attempt to find your AWS credentials 
            // using the default credential provider chain. The first place the chain looks for the credentials is in environment variables 
            // AWS_ACCESS_KEY_ID and AWS_SECRET_KEY. 
            // For more information, see http://docs.aws.amazon.com/AWSSdkDocsJava/latest/DeveloperGuide/credentials.html
            AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient();
               
            // Choose the AWS region of the Amazon SES endpoint you want to connect to. Note that your sandbox 
            // status, sending limits, and Amazon SES identity-related settings are specific to a given AWS 
            // region, so be sure to select an AWS region in which you set up Amazon SES. Here, we are using 
            // the 米国西部（オレゴン） region. Examples of other regions that Amazon SES supports are US_EAST_1 
            // and EU_WEST_1. For a complete list, see http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html 
            Region REGION = Region.getRegion(Regions.US_WEST_2);
            client.setRegion(REGION);
 *=============================================================================
 */
            // AmazonSimpleEmailServiceClientの互換クラスで client インスタンスを生成します。
            // 引数には、SMTPサーバ名を渡します。ご契約されている受信ホスト名を指定してください。
            CMCAmazonClient client = new CMCAmazonClient("SUBDOMAIN.smtps.jp");

            // Send the email.
            client.sendEmail(request);  
            System.out.println("Email sent!");
        }
        catch (Exception ex) 
        {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
    }
}
