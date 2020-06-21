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
            <h3 class="deep-grey-text mt-2 mb-4 pb-1 mx-5" 
            style="font-size: 3rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">You have pending requests with:</h3>
          </div>
        </div>
        <div class="form-group" v-for="user in users" :key="user.id">
            <div class = "col">
                <div class="col">
                    <label class = "treca">{{user.name}} , {{ user.email}}</label>
                    <b-button @click="showChat()" type="button"
                class="btn btn-info z-depth-2">Chat with {{user.name}}</b-button>
                </div>
            </div>
            <div class="big" v-if="true">
                <div class = "col ajmo" v-for="chat in chats" :key="chat.id">
                    <div v-if="'srbija@gmail.com' + user.email  === chat.id || user.email + 'srbija@gmail.com' === chat.id">
                        <div v-for="message in chat.messages" :key="message.id">
                            {{message.sender.name}}: {{message.messageText}}
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
                receiver: '',
                messageText: '',
                date: ''
            },
            agents: [],
            users: [],
            chata: '',
            chats: [],
            messages: []
        }
    },

    methods: {

        sendMessage(user) {
            this.form.receiver = user;
            this.form.date = new Date();
            axios
            .post("/message/message",this.form)
            .then(chata => {
                this.chata = chata.data
                //this.error = false;
            })
            .catch(error => {
                console.log(error);
                //this.errormessage = "Mail vec postoji";
                //this.error = true;
            });

            axios
            .get("/message/chats")
            .then(chats => {
                this.chats = chats.data;
            })
            .catch(error => {
                console.log(error);
            });
        },

        showChat() {
            axios
            .get("/message/chats")
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
        axios
        .get("/agent/agents")
        .then(agents => {
            this.agents = agents.data;
        })
        .catch(error => {
            console.log(error);
        });


        axios
        .get("/user/users")
        .then(users => {
            this.users = users.data;
        })
        .catch(error => {
            console.log(error);
        });


        axios
        .get("/message/chats")
        .then(chats => {
            this.chats = chats.data;
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