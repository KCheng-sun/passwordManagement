import React, { useEffect, useState } from 'react'
import { Drawer, Form, Input, Radio, Checkbox, Button } from 'antd'
import service from '../service'
import constantMng from '@/utils/constant-mng'

const genderList = constantMng.getGroup('gender')
const roleList: any = constantMng.formatGroup('role', 'value', 'label')

const formItemLayout = {
	labelCol: { span: 4 },
	wrapperCol: { span: 20 },
}

interface IProps {
	visible: boolean
	id: number
	onClose: () => void
}

const Edit: React.FC<IProps> = props => {
	const { id, visible, onClose } = props
	// 提交时的loading状态
	// const [loading, setLoading] = useState(false)
	const [form] = Form.useForm<{ mobile: string; password: string }>()

	// 获取用户详情
	useEffect(() => {
		if (!id) return
		service.getUserDetail(id).then(res => {
			form.setFieldsValue({ mobile: res.mobile, password: res.password })
		})
	}, [form, id])

	const handleSubmit = (values: any) => {
		if (id) {
			service.updateUser(id, values).then(res => {
				$message.success('修改成功')
				onClose()
			})
		} else {
			service.addUser(values).then(res => {
				$message.success('新增成功11')
				onClose()
			})
		}
	}

	const handleFinishFailed = () => {
		$message.warning('请按照正确格式填写信息！')
	}

	return (
		<Drawer
			title={`${id ? '修改' : '新增'}用户`}
			width={400}
			visible={visible}
			onClose={onClose}
			footer={null}
			destroyOnClose={true}
		>
			<Form
				layout="horizontal"
				colon
				labelAlign="left"
				{...formItemLayout}
				onFinish={handleSubmit}
				onFinishFailed={handleFinishFailed}
				form={form}
			>
				<Form.Item
					label="手机号"
					name="mobile"
					rules={[
						{
							required: true,
							message: '请输入用户手机号!',
						},
					]}
				>
					<Input placeholder="请输入手机号" />
				</Form.Item>

				<Form.Item
					label="密码"
					name="password"
					rules={[
						{
							required: true,
							message: '请输入密码!',
						},
					]}
				>
					<Input placeholder="请输入密码" />
				</Form.Item>

				<Form.Item wrapperCol={{ offset: 8 }}>
					<Button onClick={onClose}>取消</Button>
					<Button type="primary" htmlType="submit" style={{ marginLeft: '20px' }}>
						确认
					</Button>
				</Form.Item>
			</Form>
		</Drawer>
	)
}

export default Edit
