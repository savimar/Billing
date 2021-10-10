package ru.savimar.billing.entity;


import javax.persistence.*;

@Entity
@Table(name="bills")
public class Bill {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(name = "account")
   private int account;
   @OneToOne
   @JoinColumn(name="user_id", nullable = false)
   private User user;

   public Bill() {
   }

   public Bill(User user) {
      this.user = user;
      this.account=0;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }



   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getAccount() {
      return account;
   }

   public void setAccount(int account) {
      this.account = account;
   }
}
