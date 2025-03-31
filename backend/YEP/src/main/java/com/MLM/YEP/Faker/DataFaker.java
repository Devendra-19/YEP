package com.MLM.YEP.Faker;
import com.MLM.YEP.Entities.ProductEntity;
import com.MLM.YEP.Entities.ReferralCodeEntity;
import com.MLM.YEP.Entities.UserEntity;
import com.MLM.YEP.Repository.ProductRepository;
import com.MLM.YEP.Repository.ReferralRepository;
import com.MLM.YEP.Repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;


@Component
@Profile("dev")
public class DataFaker implements CommandLineRunner {
    private final Faker faker = new Faker() ;
    private final Random random = new Random() ;
    UserRepository userRepository ;
    ReferralRepository referralRepository ;
    ProductRepository productRepository ;

    public DataFaker(UserRepository userRepository,
                     ReferralRepository referralRepository,
                     ProductRepository productRepository){
        this.userRepository = userRepository ;
        this.referralRepository = referralRepository ;
        this.productRepository = productRepository ;
    }


    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() == 0){
            IntStream.range(0,20).forEach(i->{
                UserEntity user = new UserEntity() ;
                user.setName(faker.name().fullName());
                user.setEmail(faker.internet().emailAddress()) ;
                UserEntity userCreated = userRepository.save(user) ;
                ReferralCodeEntity referralCode = new ReferralCodeEntity() ;
                referralCode.setCode(faker.bothify("REF###??"));
                referralCode.setUser(userCreated) ;
                referralRepository.save(referralCode) ;
                userRepository.save(userCreated) ;
            });
            System.out.println("Fake Data Generated") ;
        }

        if(productRepository.count() == 0){
            IntStream.range(0,10).forEach(i->{
                ProductEntity product = new ProductEntity() ;
                product.setName(faker.commerce().productName());
                product.setDescription(faker.lorem().sentence()) ;
                product.setPrice(50 + random.nextDouble() * 100);
                product.setUrl("https://media.istockphoto.com/id/1300459022/photo/natural-organic-spa-cosmetic-products-set-with-eucalyptus-leaves-top-view-herbal-skincare.jpg?s=612x612&w=0&k=20&c=_xkB2_OnFqzJKVdDCeNCPeMp4jwLTsSQy2VvRloiPgk=");
                productRepository.save(product) ;
            });
            System.out.println("Fake Product Generated") ;
        }
    }
}
