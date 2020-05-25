# oauth登录认证系统接口测试.postman_collection.json
{
	"info": {
		"_postman_id": "afcfd536-4ca1-442b-9a6f-2186bdea444b",
		"name": "oauth登录认证系统接口测试",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "用户管理",
			"item": [
				{
					"name": "查询用户详情",
					"request": {
						"auth": {
							"type": "noauth"
						},
						"method": "GET",
						"header": [
							{
								"key": "access_token",
								"value": "35371109-b0ee-4300-8d0f-bcb7ef50306f",
								"type": "text"
							}
						],
						"url": {
							"raw": "localhost:8351/data/user/1?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"user",
								"1"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "保存用户信息",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n\t\"id\":8,\n\t\"userName\":\"test123\",\n\t\"password\":\"123456\",\n\t\"phone\" : \"15944215511\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8351/data/user?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"user"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "删除用户信息",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "localhost:8351/data/user/2?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"user",
								"2"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "查询用户列表",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "localhost:8351/data/user?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"user"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				}
			],
			"protocolProfileBehavior": {}
		},
		{
			"name": "角色管理",
			"item": [
				{
					"name": "保存角色信息",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n\t\"name\":\"用户管理员\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8351/data/role?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"role"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "查询角色列表",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "localhost:8351/data/role?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"role"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "查询角色详情",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "localhost:8351/data/role/1?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"role",
								"1"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "删除角色",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "localhost:8351/data/role/2?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"role",
								"2"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				}
			],
			"protocolProfileBehavior": {}
		},
		{
			"name": "资源管理",
			"item": [
				{
					"name": "删除资源",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "localhost:8351/data/resource/1?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"resource",
								"1"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "保存资源信息",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n\t\"name\":\"查询用户列表\",\n\t\"url\":\"/data/user\",\n\t\"method\":\"POST\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "localhost:8351/data/resource?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"resource"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "查询资源详情",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "localhost:8351/data/resource/3?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"resource",
								"3"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "查询资源列表",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "localhost:8351/data/resource?access_token=88f1c41a-e634-4dfc-913b-be5ecf82cd93",
							"host": [
								"localhost"
							],
							"port": "8351",
							"path": [
								"data",
								"resource"
							],
							"query": [
								{
									"key": "access_token",
									"value": "88f1c41a-e634-4dfc-913b-be5ecf82cd93"
								}
							]
						}
					},
					"response": []
				}
			],
			"protocolProfileBehavior": {}
		},
		{
			"name": "登录",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "login_test",
							"type": "string"
						},
						{
							"key": "username",
							"value": "login_test",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "formdata",
					"formdata": [
						{
							"key": "grant_type",
							"value": "password",
							"type": "text",
							"disabled": true
						},
						{
							"key": "username",
							"value": "test1",
							"type": "text",
							"disabled": true
						},
						{
							"key": "password",
							"value": "1234",
							"type": "text",
							"disabled": true
						},
						{
							"key": "scope",
							"value": "all",
							"type": "text",
							"disabled": true
						}
					]
				},
				"url": {
					"raw": "localhost:8351/oauth/token?grant_type=password&username=test&password=123456&client_id=login_test&client_secret=123456&scope=all",
					"host": [
						"localhost"
					],
					"port": "8351",
					"path": [
						"oauth",
						"token"
					],
					"query": [
						{
							"key": "grant_type",
							"value": "password"
						},
						{
							"key": "username",
							"value": "test"
						},
						{
							"key": "password",
							"value": "123456"
						},
						{
							"key": "client_id",
							"value": "login_test"
						},
						{
							"key": "client_secret",
							"value": "123456"
						},
						{
							"key": "scope",
							"value": "all"
						}
					]
				}
			},
			"response": []
		}
	],
	"protocolProfileBehavior": {}
}
