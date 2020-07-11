<template>
    <div>
        <!-- <div class="form-group" v-for="user in users" :key="user.id">
            <div class = "row">
                <div class="col">
                    <label class = "treca">{{user.name}}</label>
                    <button @click="showChat()">Show chat</button>
                </div>
                <div class="col druga">
                    <input type="text" id="Form-message" class="form-message" v-model="form.messageText" />
                    <button class="cetvrta" @click="sendMessage(user)">Send message</button>
                </div>
            </div>
            <div class = "row ajmo" v-for="chat in chats" :key="chat.id">
                <div v-if="'srbija@gmail.com' + user.email  === chat.id || user.email + 'srbija@gmail.com' === chat.id">
                    <div v-for="message in chat.messages" :key="message.id">
                        {{message.sender.name}}: {{message.messageText}}
                    </div>
                </div>
            </div>
        </div> -->







<div class="container d-flex justify-content-center" style="margin-top: 20px">


    <div class="card" style="width: 120%">
            <div class="header pt-3 grey lighten-2">
          <div class="row d-flex justify-content-start">
            <h3 class="deep-grey-text mt-3 mb-2 pb-1 mx-5" 
            style="font-size: 2rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">You have pending requests with:</h3>
          </div>
        </div>
        <div class="form-group" v-for="user in users" :key="user.id">
            <div v-for="showUser in userPendingRequest" :key="showUser">
                <div class = "col" v-if="user.id != idLogged && user.id === showUser">
                    <div class="col">
                        <label class = "treca">{{user.name}} , {{ user.email}}</label>
                        <b-button @click="showChat(user.id)" type="button"
                    class="btn btn-info z-depth-2">Chat with {{user.name}}</b-button>
                    </div>
                </div>
            </div>
            <div class="big" v-if="user.id === show">
                <div class = "col ajmo" v-for="chat in chats" :key="chat.id">
                    <div v-if="loggedUser.email + user.email  === chat.id || user.email + loggedUser.email === chat.id">
                        <div v-for="message in chat.messages" :key="message.id">
                            <div v-if="message.sender_id == idLogged">
                                <!-- {{message.sender_id.id}}: {{message.messageText}} -->
                                You : {{message.messageText}}
                            </div>
                            <div v-else>
                                {{user.name}} : {{message.messageText}}
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col druga">
                        <input type="text" id="Form-message" class="form-message" v-model="form.messageText" />
                        <b-button class="cetvrta" @click="sendMessage(user)">Send message</b-button>
                </div>
            </div>
        </div>
</div>

</div>

            
            



            <!-- PORUKE IZ CETA -->
            <!-- <div class = "ajmo" v-for="chat in chats" :key="chat.id">
                <div v-if="'srbija@gmail.com' + user.email  === chat.id || user.email + 'srbija@gmail.com' === chat.id">
                    <div v-for="message in chat.messages" :key="message.id">
                        {{message.sender.name}}: {{message.messageText}}
                    </div>
                </div>
            </div> -->



                <!-- POLJE ZA KUCANJE PORUKE I DUGME ZA SLANJE -->
                <!-- <div class="col druga">
                    <input type="text" id="Form-message" class="form-message" v-model="form.messageText" />
                    <button class="cetvrta" @click="sendMessage(user)">Send message</button>
                </div> -->

        
    </div>
    
</template>


<script>
import axios from "axios";
export default {
    data() {
        return {
            form: {
                sender_id: '',
                receiver_id: '',
                messageText: '',
                date: ''
            },
            agents: [],
            users: [],
            chata: '',
            chats: [],
            messages: [],
            showUserMap: [],
            show: 0,
            userPendingRequest: [],
            loggedUser: '',
            idLogged: '',
            rokaj : ''
        }
    },

    methods: {

        sendMessage(user) {
            if(this.form.messageText == "") {
                return;
            }
            // this.form.sender.id = this.$store.user.id;
            this.form.receiver_id = user;
            this.form.sender_id = this.loggedUser;
            // user;
            this.form.date = new Date();
    
            axios
            .post("/order/message/message/" + this.$store.state.user.id + "/agentSender",this.form)
            .then(chata => {
                this.chata = chata.data
                this.form.messageText = "";
                return axios.get("/order/message/chats");
            })
            .then(chats => {
                this.chats = chats.data;
            })
            .catch(error => {
                console.log(error);
            });
        },

        showChat(id) {
            this.form.messageText = "";
            this.show = id;
            axios
            .get("/order/message/chats")
            .then(chats => {
                this.chats = chats.data;
                // this.chats.forEach(chat => {
                //     chat.show = true;
                // })
            })
            .catch(error => {
                console.log(error);
            });
        }




    },

    mounted() {
        this.show = 0;
        axios
        .get("/order/agent/agents")
        .then(agents => {
            this.agents = agents.data;
        })
        .catch(error => {
            console.log(error);
        });


        axios
        .get("/auth/auth/users")
        .then(users => {
            this.users = users.data;
            // this.users.forEach(user => {
            //     this.showUserMap = new Map(false,user);
            // })
            this.showUserMap = new Array(4);
            this.showUserMap.forEach(map => {
                map = false;
                map;
            })
            
    
            // this.chats.forEach(chat => {
                //     chat.show = true;
                // })
        })
        .catch(error => {
            console.log(error);
        });


        axios
        .get("/order/message/chats")
        .then(chats => {
            this.chats = chats.data;
        })
        .catch(error => {
            console.log(error);
        });


        axios
        .get("/order/message/chats")
        .then(chats => {
            this.chats = chats.data;
        })
        .catch(error => {
            console.log(error);
        });

        axios
        .get("/order/message/" + + this.$store.state.user.id + "/user")
        .then(userPendingRequest => {
            this.userPendingRequest = userPendingRequest.data;
        })
        .catch(error => {
            console.log(error);
        });


        // axios
        //   .get("/order/user/loggedUser")
        //   .then(loggedUser => {
        //       this.loggedUser= loggedUser.data
        //   })
        //   .catch(error => {
        //     console.log(error);
        //   });

        
        axios
          .get("/auth/feign/" + this.$store.state.user.id + "/user" )
          .then(loggedUser => {
              this.loggedUser= loggedUser.data
              this.idLogged = this.$store.state.user.id;
          })
          .catch(error => {
            console.log(error);
          });

    }
}
</script>

<style scoped>
    .druga {
        background-color : white;
        margin: 0px;
    }

    .treca {
        background-color: white;
        margin : 20px;
    }

    .cetvrta {
        margin: 10px;
    }

    .form-group {
        margin: 0px;
        padding: 0px;
    }

    .row {
        /* width: 100px; */
    }

    .ajmo {
        background-color: white;
        padding-left : 40px;
    }

    .big {
        width: 700px;
    }

    .form-group {
        padding-left: 100px;
    }


</style>