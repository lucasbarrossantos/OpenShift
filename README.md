Este é um projeto base para quem deseja publicar sua aplicação java na nuvem.

#OpenShift
#Banco: mysql
#JSF
#PrimeFaces

<b>`Obs: A conexão não é feita local! Após a publicação, sua aplicação irá se conectar ao banco que você criou no OpenShift`</b>

<hr/>

`Crie um banco local com o mesmo nome do banco da nuvem e em seguida troque a conexão do persistence, assim os testes podem ser feitos local! Quando publicar, basta apenas comentar no pacote 'util' -> classe -> 'PersistenceManager', as credenciais de acesso. Trocando pelas credenciais de acesso ao banco da nuvem.`

http://openshift.github.io/documentation/oo_cartridge_guide.html#tomcat
